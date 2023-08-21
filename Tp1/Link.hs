-- { Un Link es el medio físico que une dos ciudades. }
module Link (Link (..), newL, linksL, connectsL, capacityL, delayL) where

import City (City (..), distanceC, nameC, newC)
import Point (Point (..), difP, newP)
import Quality (Quality (..), capacityQ, delayQ, newQ)

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL = Lin

connectsL :: City -> Link -> Bool -- indica si esta ciudad es parte de este link
connectsL (Cit nombre _) (Lin ciudad1 ciudad2 _)
  | nombre == nameC ciudad1 || nombre == nameC ciudad2 = True
  | otherwise = False

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas están conectadas mediante este link
linksL (Cit nom1 _) (Cit nom2 _) (Lin ciudad1 ciudad2 _)
  | (nom1 == nameC ciudad1 && nom2 == nameC ciudad2) || (nom1 == nameC ciudad2 && nom2 == nameC ciudad1) = True
  | otherwise = False

-- { Un Link es naturalmente bidireccional, Si las ciudades A y B están enlazadas por un link li, linksL A B li y linksL B A li es true }

capacityL :: Link -> Int
capacityL (Lin _ _ calidad) = capacityQ calidad

delayL :: Link -> Float -- la demora que sufre una conexión en este canal
delayL (Lin _ _ calidad) = delayQ calidad

-- { esta demora es en unidades de tiempo }
-- { La demora de un link es en tiempo, segundos, milisegundos, etc.
-- La demora de la calidad de un enlace es en velocidad, por ejemplo km/segundo.
-- No importan las unidades, sí la relación entre los valores }

t :: [Bool]
t =
  [ newL (Cit "Igna" (Poi 1 0)) (Cit "Mati" (Poi 0 1)) (Qua "Bronce" 1 2.0) == Lin (Cit "Igna" (Poi 1 0)) (Cit "Mati" (Poi 0 1)) (Qua "Bronce" 1 2.0),
    True
  ]