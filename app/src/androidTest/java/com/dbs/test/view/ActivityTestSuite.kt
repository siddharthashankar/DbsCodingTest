package com.dbs.test.view

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
        MainActivityTest::class,
        ArticleDetailsActivityTest::class
)
class ActivityTestSuite {
}