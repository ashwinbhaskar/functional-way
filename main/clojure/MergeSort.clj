(defn mid-point [arr] (/ (count arr) 2))

(defn merge-sorted-arrays
      "Merges two sorted arrays and returns a sorted array"
      [sorted-arr1 sorted-arr2]
      (cond
        (and (empty? sorted-arr1) (empty? sorted-arr2)) []
        (empty? sorted-arr1) sorted-arr2
        (empty? sorted-arr2) sorted-arr1
        :else (if (< (first sorted-arr1) (first sorted-arr2))
                (cons (first sorted-arr1) (merge-sorted-arrays (rest sorted-arr1) sorted-arr2))
                (cons (first sorted-arr2) (merge-sorted-arrays (rest sorted-arr2) sorted-arr1)))
        )
      )


(defn merge-sort
      "Implements the merge sort algorithm and returns a sorted array"
      [num-array]
      (let [first-half (take (mid-point num-array) num-array)
            second-half (drop (mid-point num-array) num-array)]
           (cond
             (and (= (count first-half) 1) (= (count second-half) 1)) (merge-sorted-arrays first-half second-half)
             (empty? first-half) (merge-sorted-arrays [] second-half)
             (empty? second-half) (merge-sorted-arrays [] first-half)
             :else (merge-sorted-arrays (merge-sort first-half) (merge-sort second-half)))
           ))



