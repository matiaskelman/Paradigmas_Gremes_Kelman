-- { Un Tunel es la conexión lógica que podemos establecer entre dos puntos, también es bidireccional }
module Tunel (Tunel, newT, connectsT, usesT, delayT) where

import City (City (..), distanceC, nameC, newC)
import Link (Link (..), capacityL, connectsL, delayL, linksL, newL)
import Point (Point (..), difP, newP)
import Quality (Quality (..), capacityQ, delayQ, newQ)

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
-- { El newT recibe una lista de links ordenada y válida, donde los extremos son los extremos del túnel. (Que sea válida significa que no hace falta revisarla) }

connectsT :: City -> City -> Tunel -> Bool -- indica si éste túnel conecta estas dos ciudades distintas
connectsT (Cit name1 _) (Cit name2 _) [(Lin (Cit nameC1 _) (Cit nameC2 _) _)]
  | (name1 == nameC1 || name2 == nameC2) && (name1 == nameC2 || name2 == nameC1) = True
  | otherwise = False

-- { dadas dos ciudades esta función da si si las ciudades son los extremos del túnel }

usesT :: Link -> Tunel -> Bool -- indica si este túnel atraviesa ese link
-- { Un túnel recorre una serie de uno o más links, esta función indica si el link consultado es parte de esa serie }
delayT :: Tunel -> Float -- la demora que sufre una conexión en este túnel
-- { esta demora es en unidades de tiempo, cuanto demora la información en recorrer el túnel }
t :: [Bool]
t =
  [ connectsT (Cit "Igna" (Poi 1 0)) (Cit "Mati" (Poi 0 1)) (Tun ([Lin (Cit "Igna" (Poi 1 0)) (Cit "Mati" (Poi 0 1)) (Qua "Bronce" 1 2.0)])),
    True
  ]