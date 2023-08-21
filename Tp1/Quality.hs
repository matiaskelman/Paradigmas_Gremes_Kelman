module Quality ( Quality(..), newQ, capacityQ, delayQ )
where

import Point ( Point(..), newP, difP )
import City ( City(..), newC, nameC, distanceC )

data Quality = Qua String Int Float deriving (Eq, Show)


newQ :: String -> Int -> Float -> Quality --String indica el material, ej: "bronce","aluminio",etc
newQ = Qua
capacityQ :: Quality -> Int -- cuantos túneles puede tolerar esta conexión
capacityQ (Qua _ capacidad _) = capacidad
delayQ :: Quality -> Float -- la demora por unidad de distancia que sucede en las conexiones de este canal
delayQ (Qua _ _ demora) = demora