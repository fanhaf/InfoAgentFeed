(ns infoagent.controllers.mpk
  (:use [compojure.core :only (defroutes GET)]))

(defn get-mpk-status []
  (str "Nothing wrong..."))

(defroutes routes
  (GET "/mpk/" [] (get-mpk-status)))
