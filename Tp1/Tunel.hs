-- { Un Tunel es la conexión lógica que podemos establecer entre dos puntos, también es bidireccional }
module Tunel (Tunel, newT, connectsT, delayT, usesT) where

import City (City , distanceC, nameC, newC)
import Link (Link , capacityL, connectsL, delayL, linksL, newL)
import Point (Point , difP, newP)
import Quality (Quality , capacityQ, delayQ, newQ)
import Data.Text.Array (new)

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

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


usesT :: Link -> Tunel -> Bool -- indica si este túnel atraviesa ese link
usesT l (Tun t) 
  | length[y | y <- t, y == l] >= 1 = True
  | otherwise = False

delayT :: Tunel -> Float -- la demora que sufre una conexión en este túnel
delayT (Tun links) = foldr (\link acc -> delayL link + acc) 0 links

