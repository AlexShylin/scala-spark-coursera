package stackoverflow

import org.apache.spark.{SparkConf, SparkContext}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{BeforeAndAfterAll, FunSuite}

@RunWith(classOf[JUnitRunner])
class StackOverflowSuite extends FunSuite with BeforeAndAfterAll {


  lazy val testObject = new StackOverflow {
    override val langs =
      List(
        "JavaScript", "Java", "PHP", "Python", "C#", "C++", "Ruby", "CSS",
        "Objective-C", "Perl", "Scala", "Haskell", "MATLAB", "Clojure", "Groovy")

    override def langSpread = 50000

    override def kmeansKernels = 45

    override def kmeansEta: Double = 20.0D

    override def kmeansMaxIterations = 120
  }

  test("testObject can be instantiated") {
    val instantiatable = try {
      testObject
      true
    } catch {
      case _: Throwable => false
    }
    assert(instantiatable, "Can't instantiate a StackOverflow object")
  }

//  test("debugging") {
//    @transient lazy val conf: SparkConf = new SparkConf().setMaster("local").setAppName("StackOverflow")
//    @transient lazy val sc: SparkContext = new SparkContext(conf)
//    val posts = Seq (
//      Posting(1, 1, None, None, 3, Some("C++")),
//      Posting(1, 2, None, None, 4, None),
//      Posting(1, 3, None, None, 2, Some("MATLAB")),
//      Posting(2, 4, None, Some(1), 6, Some("C++")),
//      Posting(2, 5, None, Some(1), 1, Some("C++")),
//      Posting(2, 6, None, Some(1), 8, Some("C++")),
//      Posting(2, 7, None, Some(2), 9, None),
//      Posting(2, 8, None, Some(3), 3, None),
//      Posting(2, 9, None, Some(3), 2, None)
//    )
//    val lines = sc.parallelize(posts)
//    val grouped = testObject.groupedPostings(lines)
//    val res = grouped.collect()
//    println(res.length)
//    res.foreach(println)
//    sc.stop()
//  }

}
