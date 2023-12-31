
module Link (Link , newL, linksL, connectsL, capacityL, delayL) 
    where

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

capacityL :: Link -> Int
capacityL (Lin _ _ quality) = capacityQ quality

delayL :: Link -> Float -- la demora que sufre una conexión en este canal
delayL (Lin _ _ quality) = delayQ quality

