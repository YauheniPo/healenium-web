/**
 * Healenium-web Copyright (C) 2019 EPAM
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.epam.healenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTest {

    private SelfHealingDriver driver;

    @Before
    public void createDriver() {
        WebDriver delegate = new ChromeDriver();
        driver = SelfHealingDriver.create(delegate);
    }

    @Test
    public void name() {
        driver.get("https://google.com.ua");
        try{
            new Actions(driver)
                .moveToElement(driver.findElement(By.name("q")))
                .click()
                .sendKeys("search")
                .build()
                .perform();
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @After
    public void close() {
        driver.quit();
    }
}
