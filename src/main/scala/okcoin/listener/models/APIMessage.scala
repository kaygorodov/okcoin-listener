package okcoin.listener.models

/**
  * Created by andreykaygorodov on 12/07/2017.
  * api link https://www.okcoin.com/ws_request.html
  */

class Parameter(name: String, value: String)

sealed abstract class Event(name: String)

object Event {
  case object AddChanel extends Event("addChannel")
  case object RemoveChanel extends Event("removeChannel")
}


sealed abstract class Channel(name: String)

object Channel {
  case object OK_SUB_SPOTCNY_BTC_KLINE_1MIN extends Channel("ok_sub_spotcny_btc_kline_1min")
  case object OK_SUB_SPOTUSD_BTC_TICKER extends Channel("ok_sub_spotusd_btc_ticker")
  case object OK_SUB_SPOTUSD_LTC_TICKER extends Channel("ok_sub_spotusd_ltc_ticker")
  //TODO add the rest to be added
}

case class APIMessage(event: Event, channel: Channel, parameters: Seq[Parameter])

//TODO model and add error codes/messages
