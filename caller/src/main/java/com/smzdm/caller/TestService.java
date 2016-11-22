package com.smzdm.caller;

import com.smzdm.commons.rpc.annotation.HttpAction;
import com.smzdm.commons.rpc.entity.HttpResult;
import com.smzdm.commons.rpc.enums.HttpMethod;

/**
 * Created by zhengwenzhu on 16/10/13.
 */
public interface TestService {
    @HttpAction(url = "/world", retryTimes = 1, method = HttpMethod.GET)
    HttpResult<TestResult> world();
}