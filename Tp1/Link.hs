--{ Un Link es el medio físico que une dos ciudades. }
module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
where

import Point ( Point(..), newP, difP )
import City ( City(..), newC, nameC, distanceC )
import Quality ( Quality(..), newQ, capacityQ, delayQ )

data Link = Lin City City Quality deriving (Eq, Show)


newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
connectsL :: City -> Link -> Bool -- indica si esta ciudad es parte de este link
linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas están conectadas mediante este link
--{ Un Link es naturalmente bidireccional, Si las ciudades A y B están enlazadas por un link li, linksL A B li y linksL B A li es true }
capacityL :: Link -> Int
delayL :: Link -> Float -- la demora que sufre una conexión en este canal

-- { esta demora es en unidades de tiempo }
-- { La demora de un link es en tiempo, segundos, milisegundos, etc.
-- La demora de la calidad de un enlace es en velocidad, por ejemplo km/segundo.
-- No importan las unidades, sí la relación entre los valores }