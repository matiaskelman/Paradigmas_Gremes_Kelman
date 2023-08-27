module Test () where

import City (City, distanceC, nameC, newC)
import Data.Text.Array (new)
import Distribution.Simple.Test (test)
import Link (Link, capacityL, connectsL, delayL, linksL, newL)
import Point (Point, difP, newP)
import Quality (Quality, capacityQ, delayQ, newQ)
--import Region (Region, availableCapacityForR, connectedR, delayR, foundR, linkR, linkedR, newR, tunelR)
import Tunel (Tunel, connectsT, delayT, newT, usesT)

t :: [[Bool]]
t = [testCity, testLink, testPoint, testQuality, testTunel]

-- region1 :: Region
-- region1 = tunelR (linkR (foundR newR ciudad1) ciudad1 ciudad2 calidad1) [ciudad1, ciudad2]
-- region2 :: Region
-- region2 = tunelR (linkR (foundR newR ciudad1) ciudad1 ciudad2 calidad1) [ciudad1, ciudad2]

punto1 :: Point
punto1 = newP 1 0
punto2 :: Point
punto2 = newP 0 1
punto3 :: Point
punto3 = newP 2 0
testPoint :: [Bool]
testPoint =
  [ difP punto1 punto2 == sqrt 2,
    difP punto1 punto3 == 1,
    True
  ]
ciudad1 :: City
ciudad1 = newC "Igna" punto1
ciudad2 :: City
ciudad2 = newC "Mati" punto2
ciudad3 :: City
ciudad3 = newC "Emilio Capo!" punto3
testCity :: [Bool]
testCity =
  [ nameC ciudad1 == "Igna",
    nameC ciudad2 == "Mati",
    nameC ciudad3 == "Emilio Capo!",
    distanceC ciudad1 ciudad2 == 2,
    distanceC ciudad1 ciudad3 == 1,
    True
  ]
calidad1 :: Quality
calidad1 = newQ "Bronce" 1 2.0
calidad2 :: Quality
calidad2 = newQ "Aluminio" 20 1.0
testQuality :: [Bool]
testQuality =
  [ capacityQ calidad1 == 1,
    capacityQ calidad2 == 20,
    delayQ calidad1 == 2.0,
    True
  ]
link1 :: Link
link1 = newL ciudad1 ciudad2 calidad1
link2 :: Link
link2 = newL ciudad2 ciudad3 calidad2
link3 :: Link
link3 = newL ciudad3 ciudad1 calidad2
testLink :: [Bool]
testLink =
  [ newL ciudad1 ciudad2 calidad1 == link1,
    linksL ciudad2 ciudad1 link1,
    linksL ciudad2 ciudad3 link1, -- False
    connectsL ciudad1 link1,
    capacityL link1 == 1,
    delayL link1 == 2.0,
    True
  ]
tunel1 :: Tunel
tunel1 = newT [link1, link2]
tunel2 :: Tunel
tunel2 = newT [link3, link1]
testTunel :: [Bool]
testTunel =
  [ connectsT ciudad1 ciudad3 tunel1,
    connectsT ciudad3 ciudad1 tunel1,
    connectsT ciudad1 ciudad2 tunel1, -- False
    delayT tunel1 == 3.0,
    usesT link1 tunel1,
    True
  ]
