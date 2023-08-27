module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR ) 
    where

import Point (Point , difP, newP)
import City (City , distanceC, nameC, newC)
import Quality (Quality , capacityQ, delayQ, newQ)
import Link (Link , capacityL, connectsL, delayL, linksL, newL)
import Tunel (Tunel, newT, connectsT, delayT, usesT)
import Data.List (elemIndex)
import Data.Text.Array (new)
import GHC.Exts.Heap (GenClosure(link))


data Region = Reg [City] [Link] [Tunel] deriving (Show)
newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg citys links tunels) cityNew 
    | elem cityNew citys = error "La ciudad que busca ingresar ya existe."
    | otherwise = Reg ([cityNew] ++ citys) links tunels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicadar
linkR (Reg citys links tunels) city1 city2 quality 
    | elem (newL city1 city2 quality) links  = error "El link ya existe."
    | city1 == city2 = error "Se ingreso la misma ciudad 2 veces."
    | notElem city1 citys = error "La ciudad 1 no esta en la region."
    | notElem city2 citys = error "La ciudad 2 no esta en la region."
    | otherwise = Reg citys ( [newL city1 city2 quality] ++ links) tunels
    
checkCitiesInR :: [City] -> [City] -> Bool
checkCitiesInR citiesRegion checkCitiesList 
    | length ([True | city1 <- checkCitiesList, city2 <- citiesRegion, city1 == city2]) == length checkCitiesList = True
    | otherwise = False

checkLinksInR ::  [Link] -> [City] -> Bool
checkLinksInR  links citiesList
    | foldr (\city1 fold -> [True | city2 <- tail citiesList, link <- links, linksL city1 city2 link ]) [] citiesList == [True] = True
    | otherwise = False

filterLinksInR ::  [Link] -> [City] -> [Link]                                                
filterLinksInR  links citiesList = [link | link <- links, n <- [0..(length citiesList - 2)], linksL ((!!) citiesList n) ((!!) citiesList (n+1)) link ]

checkCapacityOfLinks :: Region -> [City] -> Bool
checkCapacityOfLinks (Reg citiesR links tunels) citiesList 
    | length [True | n <- [0..(length citiesList - 2)]  , availableCapacityForR (Reg citiesR links tunels) ((!!) citiesList n) ((!!) citiesList (n+1)) > 0 ] == length (filterLinksInR links citiesList) = True
    | otherwise = False

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg citiesR links tunels) citiesList
    | not (checkCitiesInR citiesR citiesList) = error "Las ciudades no estan en la region."
    | not (checkLinksInR links citiesList) = error "Los links no estan en la region."
    | not (checkCapacityOfLinks (Reg citiesR links tunels) citiesList) = error "Los links no tienen mas capacidad disponible"  
    | otherwise = Reg citiesR links (newT(filterLinksInR links citiesList):tunels)

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg _ _ tuneles) city1 city2 
    | length[tunel | tunel <- tuneles, connectsT city1 city2 tunel] > 0 = True 
    | otherwise = False


linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades están enlazadas
linkedR (Reg citys links _) city1 city2
    | notElem city1 citys || notElem city2 citys = error "Las ciudades no estan en la region."
    | length[link | link <- links, linksL city1 city2 link] > 0 = True 
    | otherwise = False

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg _ _ tunels) city1 city2 = delayT(head[tunel | tunel <- tunels, connectsT city1 city2 tunel ])

getLink :: City -> City -> [Link] -> Link
getLink city1 city2 links = [link | link <- links, linksL city1 city2 link] !! 0

capacityUsed :: Link -> [Tunel] -> Int
capacityUsed link = foldr (\tunel acc -> if usesT link tunel then acc + 1 else acc) 0  

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cities links tunels) city1 city2 = capacityL (getLink city1 city2 links) - capacityUsed (getLink city1 city2 links) tunels

punto1 :: Point
punto1 = newP 1 0
punto2 :: Point
punto2 = newP 0 1
punto3 :: Point
punto3 = newP 2 0
punto4 :: Point
punto4 = newP 0 2
ciudad1 :: City
ciudad1 = newC "Igna" punto1

ciudad2 :: City
ciudad2 = newC "Mati" punto2

ciudad3 :: City
ciudad3 = newC "jojo" punto3

ciudad4 :: City
ciudad4 = newC "lucas" punto4

ciudad5 :: City
ciudad5 = newC "ernesto" punto4

ciudad6 :: City
ciudad6 = newC "fede" punto1

calidad1 :: Quality
calidad1 = newQ "Bronce" 1 2.0

calidad2 :: Quality
calidad2 = newQ "Aluminio" 20 1.0

calidad3 :: Quality
calidad3 = newQ "Oro" 5 3.0

link1 = newL ciudad1 ciudad2 calidad1
link2 = newL ciudad2 ciudad3 calidad2
link3 = newL ciudad3 ciudad4 calidad3
link4 = newL ciudad4 ciudad5 calidad1

tunel1 = newT [link1, link2]
tunel2 = newT [link1, link2, link3]
tunel3 = newT [link2, link3]
region1 = Reg [ciudad1, ciudad2, ciudad3, ciudad4, ciudad5] [link1, link2, link3] [tunel2]
region2 = Reg [ciudad1,ciudad2,ciudad3] [link1,link2]

t :: [Bool]
t = [
    [True | city1 <- [ciudad1,ciudad2,ciudad3], city2 <- [ciudad2,ciudad3], link <- [link1,link2], linksL city1 city2 link] == [True,True,True]
    ]

-- region1 = Reg [ciudad1, ciudad2, ciudad3, ciudad4, ciudad5] [link1, link2, link3] [tunel1]
-- (ciudad1-link1-ciuidad2-link2-ciudad3-link3-ciudad4) tunel1
-- linkR region1 ciudad4 ciudad5 calidad1
-- region1 = Reg [ciudad1, ciudad2, ciudad3, ciudad4, ciudad5] [link1, link2, link3, link4] [tunel1]
