module Main (Region, newR) where

import Tunel (Tunel, newT, connectsT, usesT)
import City (City , distanceC, nameC, newC)
import Link (Link , capacityL, connectsL, delayL, linksL, newL)
import Point (Point , difP, newP)
import Quality (Quality , capacityQ, delayQ, newQ)
import Data.Text.Array (new)

data Region = Reg [City] [Link] [Tunel]
newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg [citys] _ _) cityNew = cityNew : [citys]

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicadar
linkR city1 city2 q = newL 