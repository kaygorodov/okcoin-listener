package okcoin.listener.models

/**
  * Created by andreykaygorodov on 18/07/2017.
  */
sealed class ErrorCode(code: Int)

object ErrorCode {
  case object RequiredParameterIsEmpty extends ErrorCode(10000)
  case object IllegalParameters extends ErrorCode(10001)
  /*
  TODO: add the following
  10002	Authentication failure
  10003	This connection has requested other user data
    10004	This connection did not request this user data
  10005	System error
  10008	Parameter erorr
  10009	Order does not exist
  10010	Insufficient funds
  10011	Order quantity too low
  10012	Only support btc_usd ltc_usd
  10014	Order price must be between 0 - 1,000,000
  10015	Channel subscription temporally not available
    10016	Insufficient coins
  10017	WebSocket authorization error
    10100	user frozen
  10216	non-public API
    10049	User can not have more than 50 unfilled small orders (amount<0.15BTC)
  20001	user does not exist
  20002	user frozen
  20003	frozen due to force liquidation
    20004	contract account frozen
    20005	user contract account does not exist
  20006	required field can not be null
  20007	illegal parameter
  20008	contract account fund balance is zero
  20009	contract status error
    20010	risk rate information does not exist
  20011	risk rate bigger than 90% before opening position
    20012	risk rate bigger than 90% after opening position
    20013	temporally no counter party price
    20014	system error
  20015	order does not exist
  20016	liquidation quantity bigger than holding
    20017	not authorized/illegal order ID
  20018	order price higher than 105% or lower than 95% of the price of last minute
    20019	IP restrained to access the resource
  20020	secret key does not exist
    20021	index information does not exist
    20022	wrong API interface
    20023	fixed margin user
    20024	signature does not match
  20025	leverage rate error
    20100	request time out
    20101	the format of data is error
  20102	invalid login
  20103	event type error
  20104	subscription type error
  20107	JSON format error
  */
}