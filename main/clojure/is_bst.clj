;
;Given a Binary tree determine if the tree is BST or not
;



(defn bst?
      "given root node of a tree, determine if the tree is a bst"
      [{value :value, left-child :left-child, right-child :right-child}]
      (let [left-child-value (:value left-child)
            right-child-value (:value right-child)]
           (cond
             (and (nil? left-child) (nil? right-child)) true
             (nil? left-child) (>= right-child-value value)
             (nil? right-child) (<= left-child-value value)
             (and (<= left-child-value value right-child-value)) (and (bst? left-child) (bst? right-child))
             :else false)))


(defn create-node
      "returns a node with left and right children attached"
      [value left-child right-child]
      {:value value :left-child left-child :right-child right-child})


(def root (into {} (create-node
                     5
                     (create-node
                       3
                       (create-node
                         2
                         nil
                         nil)
                       (create-node
                         4
                         nil
                         nil))
                     (create-node
                       7
                       (create-node
                         6
                         nil
                         nil)
                       (create-node
                         8
                         nil
                         nil)))))

;Execute the code inside comment in repl to test

(comment
  (bst? root))


