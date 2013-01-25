(ns infoagent.core 
  (:use [compojure.core :only (defroutes)])
  (:require [infoagent.controllers.mpk :as mpk]
            [ring.middleware.params :as params]))

(defroutes routes
  mpk/routes)

(def application (params/wrap-params routes))

