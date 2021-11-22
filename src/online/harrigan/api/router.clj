(ns online.harrigan.api.router
  {:author ["David Harrigan"]}
  (:require
   [compojure.api.sweet :refer [api middleware]]
   [compojure.route :as route]
   [online.harrigan.api.a.routes :as a-routes]
   [ring.middleware.cookies :as cookies]
   [ring.util.response :as response]))

(set! *warn-on-reflection* true)

#_{:clj-kondo/ignore [:unused-binding]}
(defn app
  [app-config]
  (api (middleware [[cookies/wrap-cookies]]

                   #'a-routes/public-routes)


       (route/not-found
        (response/not-found {:message "Page not found"}))))

;; CLIP Lifecycle Functions

; #_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
;(defn start
;  [{:keys [runtime-config] :as app-config}]
;  (jetty/run-jetty
;   (ring/ring-handler (app app-config) (ring/create-default-handler))
;   (assoc (:jetty runtime-config)
;          :send-server-version? false
;          :send-date-header? false
;          :join? false)) ;; false so that we can stop it at the repl!
;
;#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
;(defn stop
;  [^Server server]
;  (.stop server) ; stop is async
;  (.join server)) ; so let's make sure it's really stopped!
