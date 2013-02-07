(ns infoagent.controllers.mpk
  (:use [compojure.core :only (defroutes GET)])
  (:require [infoagent.models.mpk :as model]))

(defn get-mpk-status []
  (model/all))

(defroutes routes
  (GET "/mpk/" [] (get-mpk-status)))
