package thoughtworks

import org.apache.spark.sql.functions._
import org.apache.spark.sql.{Column, Dataset, Row, SparkSession}

object DiamondAnalyzer {

  implicit class DiamondsDataframe(val diamondsDF: Dataset[Row]) {

    //Total records in diamonds
    def totalQuantity(spark: SparkSession): Long = {
      diamondsDF.count()
    }

    //Average price of all diamonds
    def averagePrice(spark: SparkSession): Double = {
      import spark.implicits._
      diamondsDF.select(avg("price")).as[Double].collect()(0)
    }

    //Minimum price of all diamonds
    def minimumPrice(spark: SparkSession): Double = {
      0.0
    }

    //Maximum price of all diamonds
    def maximumPrice(spark: SparkSession): Double = {
      0.0
    }

    //Filter premium cut diamonds and fetch record count
    def totalPremiumCutDiamonds(spark: SparkSession): Long = {
      0
    }

    //Evaluate average price of diamonds by clarity using groupby and avg functions
    def averagePriceByClarity(spark: SparkSession): Dataset[Row] = {
      spark.emptyDataFrame
    }

    def dropColorColumn(spark: SparkSession): Dataset[Row] = {
      spark.emptyDataFrame
    }

    //Drop id column and then check for duplicates
    def removeDuplicateRecords(spark: SparkSession): Dataset[Row] = {
      spark.emptyDataFrame
    }

    //Populate column grade based on cut and clarity using when - otherwise conditionals
    def computeGrade(spark: SparkSession): Dataset[Row] = {
      spark.emptyDataFrame
    }

    def isGradeA(spark: SparkSession):Column = {
      import spark.implicits._

      (
        (lower($"cut") === lit("premium") ||
        lower($"cut") === lit("ideal"))
      &&
        (lower($"clarity") === lit("fl")  ||
        lower($"clarity") === lit("if")   ||
        lower($"clarity") === lit("vvs1") ||
        lower($"clarity") === lit("vvs2"))
      )
    }

    def isGradeB(spark: SparkSession):Column = {
      import spark.implicits._

      (
        (lower($"cut") === lit("very good") ||
        lower($"cut") === lit("good"))
      &&
        (lower($"clarity") === lit("vs1") ||
        lower($"clarity") === lit("vs2")  ||
        lower($"clarity") === lit("si1")  ||
        lower($"clarity") === lit("si2"))
      )
    }
  }
}
