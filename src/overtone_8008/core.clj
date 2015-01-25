(ns overtone-8008.core
  (:use [overtone.live]))

;; simple kick drum
(definst kick [amp 0.5 decay 0.6 freq 65]
  (* (sin-osc freq (* Math/PI 0.5))
     (env-gen (perc 0 decay) 1 1 0 1 FREE)
     amp))
