(ns infoagent.views.mpk
  (:require [cheshire.core :refer :all])
  )

(defn convert-tuple-to-map [tuple]
  "The function converts a tuple of (line, description) format to a map"
  {:line (first tuple) :desc (second tuple)})

(defn traffic-jams-as-json [jam-list]
  "Transforms the list of traffic jams from a list to json"
  (let [list-of-maps (map convert-tuple-to-map jam-list)]
    (generate-string list-of-maps)))
