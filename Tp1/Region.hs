module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR ) 
    where

import Point (Point , difP, newP)
import City (City , distanceC, nameC, newC)
import Quality (Quality , capacityQ, delayQ, newQ)
import Link (Link , capacityL, connectsL, delayL, linksL, newL)
import Tunel (Tunel, newT, connectsT, delayT, usesT)
import Data.List (elemIndex)
import Data.Text.Array (new)
-- import qualified Data.ByteString as 1

data Region = Reg [City] [Link] [Tunel] deriving (Show)
newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg citys links tunels) cityNew = Reg ([cityNew] ++ citys) links tunels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicadar
linkR (Reg citys links tunels) city1 city2 quality = Reg citys ( [newL city1 city2 quality] ++ links) tunels

checkCitiesInR :: [City] -> [City] -> Bool
checkCitiesInR citiesR citiesList 
    | length([True | city1 <- citiesList, city2 <- citiesR, city1 == city2]) == length citiesList = True
    | otherwise = False

checkLinksInR ::  [Link] -> [City] -> Bool
checkLinksInR  links citiesList
    | foldr (\city1 fold -> [True | city2 <- tail citiesList, link <- links, linksL city1 city2 link ]) [] citiesList == [True] = True
    | otherwise = False
    -- | [True | city1 <- citiesR, city2 <- tail(citiesR), link <- links, linksL city1 city2 link] == "hola"

filterLinksInR ::  [Link] -> [City] -> [Link]                                                
filterLinksInR  links citiesList = [link | link <- links,n <- [0..(length citiesList - 2)],  linksL ((!!) citiesList n) ((!!) citiesList (n+1)) link ]
    



tunelR :: Region -> [ City ] -> Region 
-- tunelR (Reg x y z) cities= Reg x y z
tunelR (Reg citiesR links tunels) citiesList 
    | checkLinksInR links citiesList && checkCitiesInR citiesR citiesList  = Reg citiesR links (newT(filterLinksInR links citiesList):tunels)

-- genera una comunicación entre dos ciudades distintas de la región
--{ la lista de ciudades indica el camino ordenado de enlaces que debe tomar el túnel de inicio  a fin }
-- No se entiende que pide tunelR (Reg citys links tunels) citysN =

connectedR :: Region -> City -> City -> Bool 
connectedR (Reg _ _ tuneles) city1 city2 
    | length[tunel | tunel <- tuneles, connectsT city1 city2 tunel] > 0 = True 
    | otherwise = False
-- indica si estas dos ciudades estan conectadas por un tunel

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades están enlazadas
linkedR (Reg _ links _) city1 city2
    | length[link | link <- links, linksL city1 city2 link] > 0 = True 
    | otherwise = False
--{ Dice si existe un enlace en la región que entre estas dos ciudades }


delayR :: Region -> City -> City -> Float 
delayR (Reg _ _ tunels) city1 city2 = delayT(head[tunel | tunel <- tunels, connectsT city1 city2 tunel ])
-- dadas dos ciudades conectadas, indica la demora
--{ Hay decisiones que tomar! }

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg x y z) city1 city2 = 0
-- { Teniendo en cuenta la capacidad que los túneles existentes ocupan }
-- { La conexión sólo se da a través de un túnel, y sólo se conectan los extremos }
-- { Cada vez que se refiere a 'conectadas', necesariamente se refiere a un túnel }



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
calidad1 :: Quality
calidad1 = newQ "Bronce" 1 2.0
calidad2 :: Quality
calidad2 = newQ "Aluminio" 20 1.0

link1 = newL ciudad1 ciudad2 calidad1
link2 = newL ciudad2 ciudad3 calidad2
link3 = newL ciudad3 ciudad4 calidad2
link4 = newL ciudad4 ciudad5 calidad1

tunel1 = newT [link1, link2]
tunel2 = newT [link3, link1]

region1 = newR


t :: [Bool]
t = [
    [True | city1 <- [ciudad1,ciudad2,ciudad3], city2 <- [ciudad2,ciudad3], link <- [link1,link2], linksL city1 city2 link] == [True,True,True]
    ]

-- region1 = Reg [ciudad1, ciudad2, ciudad3, ciudad4, ciudad5] [link1, link2, link3] [tunel1]
-- (ciudad1-link1-ciuidad2-link2-ciudad3-link3-ciudad4) tunel1
-- linkR region1 ciudad4 ciudad5 calidad1
-- region1 = Reg [ciudad1, ciudad2, ciudad3, ciudad4, ciudad5] [link1, link2, link3, link4] [tunel1]