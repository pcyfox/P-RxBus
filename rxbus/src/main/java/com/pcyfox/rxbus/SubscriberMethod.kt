package com.pcyfox.rxbus

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

class SubscriberMethod(
    var subscriber: Any,
    var method: Method,
    var eventType: Class<*>,
    var code: Int,
    var threadMode: ThreadMode,
    var priority: Int = 0
) : Comparable<SubscriberMethod> {

    override fun compareTo(other: SubscriberMethod): Int {
        return other.priority.compareTo(priority)
    }

    /**
     * 调用方法
     * @param o 参数
     */
    operator fun invoke(o: Any) {
        try {
            val parameterType = method.parameterTypes
            if (parameterType.size == 1) {
                method.invoke(subscriber, o)
            } else if (parameterType.isEmpty()) {
                method.invoke(subscriber)
            }
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
    }

    override fun toString(): String {
        return "priority=$priority)"
    }


}
