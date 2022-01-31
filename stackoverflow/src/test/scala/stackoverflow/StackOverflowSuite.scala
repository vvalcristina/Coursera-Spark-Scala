package stackoverflow

import org.apache.spark.SparkContext._
import org.apache.spark.{SparkConf, SparkContext}
import org.junit._

object StackOverflowSuite {
  val conf: SparkConf = new SparkConf().setMaster("local").setAppName("StackOverflow")
  val sc: SparkContext = new SparkContext(conf)
}

class StackOverflowSuite {
  import StackOverflowSuite._


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

  @Test def `testObject can be instantiated`: Unit = {
    val instantiatable = try {
      testObject
      true
    } catch {
      case _: Throwable => false
    }
    assert(instantiatable, "Can't instantiate a StackOverflow object")
  }

  @Test def `test for function scorePosting`: Unit = {
    val question1 = Posting(1,27233496,None,None,0,Some("C#"))
    val question2 = Posting(1,9419744,None,None,2,Some("Objective-C"))
    val question3 = Posting(1,9002525,None,None,0,Some("C#"))
    val question4 = Posting(1,21984912,None,None,0,Some("C#"))
    val question5 = Posting(1,20990204,None,None,0,Some("PHP"))
    val answer1 = Posting(2,20990205,None,Some(20990204),10,Some(""))
    val answer2 = Posting(2,20990206,None,Some(20990204),20,Some(""))
    val answer3 = Posting(2,20990207,None,Some(20990204),11,Some(""))
    val answer4 = Posting(2,20990208,None,Some(20990204),12,Some(""))
    val answer5 = Posting(2,20990209,None,Some(20990204),16,Some(""))
    val answer6 = Posting(2,209902010,None,Some(20990204),17,Some(""))
    val answer7 = Posting(2,209902011,None,Some(20990204),19,Some(""))
    val answer8 = Posting(2,20990205,None,Some(21984912),30,Some(""))
    val answer9 = Posting(2,20990206,None,Some(21984912),20,Some(""))
    val answer10 = Posting(2,20990207,None,Some(21984912),40,Some(""))
    val answer11 = Posting(2,20990208,None,Some(21984912),12,Some(""))
    val answer12 = Posting(2,20990209,None,Some(21984912),16,Some(""))
    val answer13 = Posting(2,209902010,None,Some(21984912),27,Some(""))
    val answer14 = Posting(2,209902011,None,Some(21984912),28,Some(""))

    val list: List[Posting] = List(question1,question2,question3,question4,question5,answer1,answer2,answer3,answer4,answer5,answer6,answer7,answer8,answer9,answer10,answer11,answer12,answer13,answer14)
    val rdd = sc.parallelize(list)
    val grouped = testObject.groupedPostings(rdd)
    grouped foreach {
      groupe => println(groupe+ "************ grouped")
    }
    testObject.scoredPostings(grouped) foreach {
      scored => println(scored+ "************ scoredPosting")
    }

  }


  @Rule def individualTestTimeout = new org.junit.rules.Timeout(100 * 1000)
}
