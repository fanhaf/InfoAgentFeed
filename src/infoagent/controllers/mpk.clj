(ns infoagent.controllers.mpk
  (:use [compojure.core :only (defroutes GET)])
  (:require [infoagent.models.mpk :as model]
            [infoagent.views.mpk :as view]))

(defn get-mpk-status []
  (view/traffic-jams-as-json (model/all)))

(defroutes routes
  (GET "/mpk/" [] (get-mpk-status)))
