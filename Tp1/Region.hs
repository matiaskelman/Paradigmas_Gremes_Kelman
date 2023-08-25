module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR ) 
    where

import Tunel (Tunel, newT, connectsT, usesT)
import City (City , distanceC, nameC, newC)
import Link (Link , capacityL, connectsL, delayL, linksL, newL)
import Point (Point , difP, newP)
import Quality (Quality , capacityQ, delayQ, newQ)
import Data.Text.Array (new)

data Region = Reg [City] [Link] [Tunel] deriving (Show)
newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg citys links tunels) cityNew = Reg (cityNew : citys) links tunels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicadar
linkR (Reg citys links tunels) city1 city2 quality = Reg citys ( newL city1 city2 quality : links) tunels

checkCitiesInR :: Region -> [City] -> Bool
checkCitiesInR (Reg citiesR links tunels) citiesList 
    | length([True | city1 <- citiesList, city2 <- citiesR, city1 == city2]) == length(citiesList) = True
    | otherwise = False

-- checkLinksInR :: Region -> [City] -> Bool
-- checkLinksInR (Reg citiesR links tunels) citiesList
--     | 

-- tunelR :: Region -> [ City ] -> Region 
tunelR :: Integer
tunelR = 0
-- tunelR (Reg citiesR links tunels) citiesList 
--     |

-- genera una comunicación entre dos ciudades distintas de la región
--{ la lista de ciudades indica el camino ordenado de enlaces que debe tomar el túnel de inicio  a fin }
-- No se entiende que pide tunelR (Reg citys links tunels) citysN =

connectedR :: Region -> City -> City -> Bool 
-- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg _ _ tuneles) city1 city2 
    | length[tunel | tunel <- tuneles, connectsT city1 city2 tunel] > 0 = True 
    | otherwise = False

--linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades están enlazadas
linkedR :: Bool
linkedR = True
--{ Dice si existe un enlace en la región que entre estas dos ciudades }

-- delayR :: Region -> City -> City -> Float 
delayR :: Float
delayR = 0.0
-- dadas dos ciudades conectadas, indica la demora
--{ Hay decisiones que tomar! }

-- availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR :: Integer
availableCapacityForR = 0
--{ Teniendo en cuenta la capacidad que los túneles existentes ocupan }


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
calidad1 :: Quality
calidad1 = newQ "Bronce" 1 2.0
calidad2 :: Quality
calidad2 = newQ "Aluminio" 20 1.0

link1 = newL ciudad1 ciudad2 calidad1
link2 = newL ciudad2 ciudad3 calidad2
link3 = newL ciudad3 ciudad4 calidad2

tunel1 = newT [link1, link2]
tunel2 = newT [link3, link1]

region1 = Reg [ciudad1, ciudad2] [link1, link2] [tunel1, tunel2]
region2 = newR

-- t :: [Bool]
-- t = [
--     newR [ciudad1, ciudad2] [link1,link2] [tunel1, tunel2] == Reg [ciudad1, ciudad2] [link1, link2] [tunel1, tunel2],
--     True
--     ]

-- region1 = Reg [ciudad1, ciudad2, ciudad3, ciudad4, ciudad5] [link1, link2, link3] [tunel1]
-- (ciudad1-link1-ciuidad2-link2-ciudad3-link3-ciudad4) tunel1
-- linkR region1 ciudad4 ciudad5 calidad1
-- region1 = Reg [ciudad1, ciudad2, ciudad3, ciudad4, ciudad5] [link1, link2, link3, link4] [tunel1]