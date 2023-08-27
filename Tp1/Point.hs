module Point (Point , newP, difP) where

data Point = Poi Int Int deriving (Eq, Show) -- Poi es una funcion que recibe 2 Int.

newP :: Int -> Int -> Point -- Nuevo Punto
newP = Poi

difP :: Point -> Point -> Float -- distancia absoluta (entre puntos)
difP (Poi x1 y1) (Poi x2 y2) 
  | x1 < 0 && x2 < 0 || y1 < 0 && y2 < 0 = abs (sqrt (fromIntegral (x1 * x1 + y1 * y1)) - sqrt (fromIntegral (x2 * x2 + y2 * y2)))
  | x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0 = abs (sqrt (fromIntegral (x1 * x1 + y1 * y1)) + sqrt (fromIntegral (x2 * x2 + y2 * y2)))
  | otherwise = abs (sqrt (fromIntegral (x1 ^ 2 + y1 ^ 2)) - sqrt (fromIntegral (x2 ^ 2 + y2 ^ 2)))

distP :: Point -> Float -- Caclula la norma de un punto.
distP (Poi x3 y3) = sqrt (fromIntegral (x3 ^ 2 + y3 ^ 2))
