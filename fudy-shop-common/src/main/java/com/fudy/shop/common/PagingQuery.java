package com.fudy.shop.common;
import lombok.Data;
import java.io.Serializable;
@Data
public class PagingQuery implements Serializable {
    private static final long serialVersionUID = 7477001786971503270L;
    /** 当前页,从1开始 */
    private int current;
    /** 每页大小 */
    private int pageSize;
    /** 获取offset */
    public int offset() {
        return (this.current-1) * this.pageSize;
    }
}