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
firstCityOfT city1 tunel1
  | connectsL city1 head(tunel1) && not(connectsL city1 head(tail tunel1)) 
  | otherwise = False 

lastCityOfT :: City -> Tunel -> Bool
firstCityOfT city1 tunel1
  | connectsL city1 last(tunel1) && not(connectsL city1 last(init tunel1))
  | otherwise = False

connectsT :: City -> City -> Tunel -> Bool -- indica si éste túnel conecta estas dos ciudades distintas
connectsT city1 city2 tunel1 = 
  | firstCityOfT city1 tunel1 && lastCityOfT city2 tunel1 || firstCityOfT city2 tunel1 && lastCityOfT city1 tunel1
  | otherwise = False

-- connectsT (Cit name1 _) (Cit name2 _) (Tun [(Lin (Cit nameC1 _) (Cit nameC2 _) _)])
--   | (name1 == nameC1 && name2 == nameC2) || (name1 == nameC2 && name2 == nameC1) = True
--   | otherwise = False

-- { dadas dos ciudades esta función da si si las ciudades son los extremos del túnel }

usesT :: Link -> Tunel -> Bool -- indica si este túnel atraviesa ese link
-- { Un túnel recorre una serie de uno o más links, esta función indica si el link consultado es parte de esa serie }
usesT l (Tun t) 
  | length[y | y <- t, y == l] == 1 = True
  | otherwise = False

delayT :: Tunel -> Float -- la demora que sufre una conexión en este túnel
delayT (Tun [Lin _ _ q]) = foldr (\q fold -> acc + q) 0 
-- { esta demora es en unidades de tiempo, cuanto demora la información en recorrer el túnel }

t :: [Bool]
t =
  [ 
    
  ]

