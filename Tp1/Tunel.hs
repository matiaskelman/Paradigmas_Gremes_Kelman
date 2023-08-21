-- { Un Tunel es la conexión lógica que podemos establecer entre dos puntos, también es bidireccional }
module Tunel ( Tunel, newT, connectsT, usesT, delayT )
where

import Point ( Point(..), newP, difP )
import City ( City(..), newC, nameC, distanceC )
import Quality ( Quality(..), newQ, capacityQ, delayQ )
import Link ( Link(..), newL, linksL, connectsL, capacityL, delayL )

data Tunel = Tun [Link] deriving (Eq, Show)


newT :: [Link] -> Tunel
-- { El newT recibe una lista de links ordenada y válida, donde los extremos son los extremos del túnel. (Que sea válida significa que no hace falta revisarla) }

connectsT :: City -> City -> Tunel -> Bool -- indica si éste túnel conecta estas dos ciudades distintas
-- { dadas dos ciudades esta función da si si las ciudades son los extremos del túnel }

usesT :: Link -> Tunel -> Bool -- indica si este túnel atraviesa ese link
-- { Un túnel recorre una serie de uno o más links, esta función indica si el link consultado es parte de esa serie }

delayT :: Tunel -> Float -- la demora que sufre una conexión en este túnel
-- { esta demora es en unidades de tiempo, cuanto demora la información en recorrer el túnel }
