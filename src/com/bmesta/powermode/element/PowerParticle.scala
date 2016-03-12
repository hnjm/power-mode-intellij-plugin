/*
 * Copyright 2015 Baptiste Mesta
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bmesta.powermode.element

import java.awt._

import org.jetbrains.annotations.NotNull

/**
  * @author Baptiste Mesta
  */
case class PowerParticle(var x: Int, var y: Int, dx: Int, dy: Int, size: Int, val _life: Int, c: (Float, Float, Float, Float)) extends ElementOfPower {
  var life = _life

  def update: Boolean = {
    x += dx
    y += dy
    life -= 1
    life <= 0
  }

  def render(@NotNull g: Graphics, dxx: Int, dyy: Int) {
    if (life > 0) {
      val g2d: Graphics2D = g.create.asInstanceOf[Graphics2D]
      g2d.setColor(new Color(c._1, c._2, c._3, c._4 * ((_life - life * 1.0f) / _life)))
      g2d.fillOval(dxx + x - (size / 2), dyy + y - (size / 2), size, size)
      g2d.dispose()
    }
  }
}