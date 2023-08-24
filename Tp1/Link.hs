-- { Un Link es el medio físico que une dos ciudades. }
module Link (Link , newL, linksL, connectsL, capacityL, delayL) where

import City (City , distanceC, nameC, newC)
import Point (Point , difP, newP)
import Quality (Quality , capacityQ, delayQ, newQ)

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL = Lin

connectsL :: City -> Link -> Bool -- indica si esta ciudad es parte de este link
connectsL city1 (Lin city2 city3 _)
  | city1 == city2 || city1 == city3 = True
  | otherwise = False 

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas están conectadas mediante este link
linksL city1 city2 (Lin city3 city4 _)
 | (city1 == city3 && city2 == city4) || (city1 == city4 && city2 == city3) = True
 | otherwise = False

-- { Un Link es naturalmente bidireccional, Si las ciudades A y B están enlazadas por un link li, linksL A B li y linksL B A li es true }

capacityL :: Link -> Int
capacityL (Lin _ _ quality) = capacityQ quality

delayL :: Link -> Float -- la demora que sufre una conexión en este canal
delayL (Lin _ _ quality) = delayQ quality

-- { esta demora es en unidades de tiempo }
-- { La demora de un link es en tiempo, segundos, milisegundos, etc.
-- La demora de la calidad de un enlace es en velocidad, por ejemplo km/segundo.
-- No importan las unidades, sí la relación entre los valores }


punto1 :: Point
punto1 = newP 1 0
punto2 :: Point
punto2 = newP 0 1
ciudad1 :: City
ciudad1 = newC "Igna" punto1
ciudad2 :: City
ciudad2 = newC "Mati" punto2
calidad1 :: Quality
calidad1 = newQ "Bronce" 1 2.0
calidad2 :: Quality
calidad2 = newQ "Aluminio" 20 1.0

t :: [Bool]
t =
  [ newL ciudad1 ciudad2 calidad1 == Lin ciudad1 ciudad2 calidad1,
    linksL ciudad2 ciudad1 (Lin ciudad1 ciudad2 calidad1),
    connectsL ciudad1 (Lin ciudad1 ciudad2 calidad1),
    capacityL (Lin ciudad1 ciudad2 calidad1) == 1,
    delayL (Lin ciudad1 ciudad2 calidad1) == 2.0,
    True
  ]
