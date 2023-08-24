-- { Un Tunel es la conexión lógica que podemos establecer entre dos puntos, también es bidireccional }
module Tunel (Tunel, newT, connectsT, usesT) where

import City (City , distanceC, nameC, newC)
import Link (Link , capacityL, connectsL, delayL, linksL, newL)
import Point (Point , difP, newP)
import Quality (Quality , capacityQ, delayQ, newQ)
import Data.Text.Array (new)

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

-- { El newT recibe una lista de links ordenada y válida, donde los extremos son los extremos del túnel. (Que sea válida significa que no hace falta revisarla) }

firstCityOfT :: City -> Tunel -> Bool
firstCityOfT city1 (Tun links) 
  | connectsL city1 (head links) && not (connectsL city1 (head(tail links))) = True
  | otherwise = False 

lastCityOfT :: City -> Tunel -> Bool
lastCityOfT city1 (Tun links)
  | connectsL city1 (last links) && not (connectsL city1 (last(init links))) = True
  | otherwise = False

connectsT :: City -> City -> Tunel -> Bool -- indica si éste túnel conecta estas dos ciudades distintas
connectsT city1 city2 tunel1
  | (firstCityOfT city1 tunel1 && lastCityOfT city2 tunel1) || (firstCityOfT city2 tunel1 && lastCityOfT city1 tunel1) = True
  | otherwise = False
-- { dadas dos ciudades esta función da si si las ciudades son los extremos del túnel }

usesT :: Link -> Tunel -> Bool -- indica si este túnel atraviesa ese link
-- { Un túnel recorre una serie de uno o más links, esta función indica si el link consultado es parte de esa serie }
usesT l (Tun t) 
  | length[y | y <- t, y == l] == 1 = True
  | otherwise = False

delayT :: Tunel -> Float -- la demora que sufre una conexión en este túnel
delayT (Tun links) = foldr (\link acc -> delayL link + acc) 0 links
  -- foldr (\each acc -> acc + delayL each) 0 
-- { esta demora es en unidades de tiempo, cuanto demora la información en recorrer el túnel }

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


tunel1 = Tun [link1,link2]


t :: [Bool]
t =
  [ 
    
  ]

