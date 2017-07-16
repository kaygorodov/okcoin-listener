package okcoin.listener.models

import spray.json._

/**
  * Created by andreykaygorodov on 12/07/2017.
  * api link https://www.okcoin.com/ws_request.html
  */

case class Parameter(name: String, value: String)

sealed abstract class Event(val name: String)

object Event {
  case object AddChanel extends Event("addChannel")
  case object RemoveChanel extends Event("removeChannel")

  def apply(name: String): Event = {
    name match {
      case "addChannel" => AddChanel
      case "removeChannel" => RemoveChanel
      case _ => throw new IllegalArgumentException(s"$name is not correct event")
    }
  }
}

sealed abstract class Channel(val name: String)

object Channel {
  case object OK_SUB_SPOTCNY_BTC_KLINE_1MIN extends Channel("ok_sub_spotcny_btc_kline_1min")
  case object OK_SUB_SPOTUSD_BTC_TICKER extends Channel("ok_sub_spotusd_btc_ticker")
  case object OK_SUB_SPOTUSD_LTC_TICKER extends Channel("ok_sub_spotusd_ltc_ticker")

  def apply(name: String): Channel = {
    name match {
      case "ok_sub_spotcny_btc_kline_1min" => OK_SUB_SPOTCNY_BTC_KLINE_1MIN
      case "ok_sub_spotusd_btc_ticker" => OK_SUB_SPOTUSD_BTC_TICKER
      case "ok_sub_spotusd_ltc_ticker" => OK_SUB_SPOTUSD_LTC_TICKER
      case _ => throw new IllegalArgumentException(s"$name is not correct channel")
    }
  }
  //TODO add the rest to be added
}

case class APIMessage(event: Event, channel: Channel, parameters: Seq[Parameter])

object OkcoinJsonProtocol extends DefaultJsonProtocol {
  implicit val parameterFormat = jsonFormat2(Parameter)

  implicit object ChannelJsonWriter extends RootJsonWriter[Channel] {
    override def write(c: Channel) = JsString(c.name)
  }

  implicit object EventJsonWriter extends RootJsonWriter[Event] {
    override def write(e: Event) = JsString(e.name)
  }

  implicit object ApiMessageFormat extends RootJsonWriter[APIMessage] {
    override def write(obj: APIMessage): JsValue = {
      JsObject(
        "event" -> obj.event.toJson,
        "channel" -> obj.channel.toJson
      )
    }
  }
}