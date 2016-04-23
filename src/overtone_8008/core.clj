(ns overtone-8008.core
  (:use [overtone.live]))

;; simple kick drum
(definst kick [amp 0.5 decay 0.6 freq 65]
  (* (sin-osc freq (* Math/PI 0.5))
     (env-gen (perc 0 decay) 1 1 0 1 FREE)
     amp))

;; low buzz
(definst lobuzz [] (lpf (saw 100) 500))

;; example interesting sound
(defsynth bizzle [out-bus 10 amp 0.5]
  (out out-bus
       (* amp
          (+ (* (decay2 (* (impulse 10 0)
                           (+ (* (lf-saw:kr 0.3 0) -0.3) 0.3))
                        0.001)
                0.3)
             (apply + (pulse [80 81]))))))
