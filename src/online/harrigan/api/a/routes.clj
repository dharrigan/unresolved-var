(ns online.harrigan.api.a.routes
  (:require
   [compojure.api.sweet :refer [defroutes GET]]
   [ring.util.response :as response]))

#_{:clj-kondo/ignore [:unused-private-var]}
(defn ^:private foo
  []
  {:oh-dear :what-can-the-matter-be})

(defroutes public-routes
  (GET "/a" [:as request]
    (response/response {:message "Hello /a World!"})))
