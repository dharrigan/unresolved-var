(ns online.harrigan.api.general.health
  {:author ["David Harrigan"]})

(set! *warn-on-reflection* true)

(def ^:private ok 200)

(def routes
  ["/ping"
   {:get {:handler (constantly {:status ok :body "Pong!"})}}])
