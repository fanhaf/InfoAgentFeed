(ns infoagent.models.mpk
  (:use [clojure.string :only (join)])
  (:require [net.cgrand.enlive-html :as enlive]))

(defn fetch-url [url]
    (enlive/html-resource (java.net.URL. url)))

(def debug-mpk-traffic-jams-url
  "file:///home/michalg/utrudnienia_two.jsp")

(def mpk-traffic-jams-url
  "http://www.mpk.lodz.pl/rozklady/utrudnienia.jsp")

(defn traffic-table-rows []
  "Extracts table rows regarding traffic jams in mpk Lodz."
  (enlive/select (fetch-url mpk-traffic-jams-url) [:table.traffic [:tr (enlive/attr? :class)]]))

(defn affected-lines [table-row]
  "Extracts line numbers that were affected by traffic jam from a specific table row of mpk page."
  (map enlive/text (enlive/select table-row [:td.lines :a])))

(defn jam-description [table-row]
  "Extracts text information from the traffic jam table row on mpk page."
  (apply str (map enlive/text (enlive/select table-row [:td.info :p]))))

(defn jam-tuples [table-row]
  "Extracts and creates a structure of jam information from a table row"
  (let [lines-list (affected-lines table-row)
        description (jam-description table-row)
        description-list (repeat (count lines-list) description)]
    (map list lines-list description-list)))

(defn all []
  "Full info from mpk website"
  (apply concat (map jam-tuples (traffic-table-rows))))

