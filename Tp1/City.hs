module City (City , newC, nameC, distanceC) where

import Point (Point , difP, newP)

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City 
newC = Cit

nameC :: City -> String 
nameC (Cit nombre _) = nombre

distanceC :: City -> City -> Float
distanceC (Cit _ posicion1) (Cit _ posicion2) = difP posicion1 posicion2