package okcoin.listener.models

import org.scalatest.FlatSpec
import spray.json._

/**
  * Created by andreykaygorodov on 18/07/2017.
  */
class JsonSerializationSpec extends FlatSpec {

  "API message" should "be serializable into JSON" in {
    import OkcoinJsonProtocol._

    assert(
      APIMessage(Event.AddChanel, Channel.OK_SUB_SPOTCNY_BTC_KLINE_1MIN, Nil).toJson.toString ==
        """{"event":"addChannel","channel":"ok_sub_spotcny_btc_kline_1min"}"""
    )
  }

}
