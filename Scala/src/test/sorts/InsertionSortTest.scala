package sorts

import com.ckeyser.sorts.InsertionSort
import com.ckeyser.util.SortUtil
import org.scalatest.FunSpec
import util.TestUtil

/**
  * Created by Chris Keyser on 9/28/2016.
  */
class InsertionSortTest extends FunSpec {
    it("should correctly sort an array") {
        val arr = TestUtil.RandomArray(TestUtil.ARR_SIZE)

        val result = InsertionSort.sort(arr)

        assert(SortUtil.isSorted(result))
    }
}
