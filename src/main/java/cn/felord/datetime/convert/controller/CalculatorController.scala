package cn.felord.datetime.convert.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(Array("calculator"))
class CalculatorController {
  @RequestMapping(Array("index"))
  def index: String = {
    "index"
  }
  @RequestMapping(Array("sum"))
  def sum: String = {
    "index"
  }

}
