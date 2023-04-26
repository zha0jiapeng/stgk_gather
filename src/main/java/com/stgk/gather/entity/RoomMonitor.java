package com.stgk.gather.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author mashir0zhao
 * @since 2023-04-24
 */
@TableName("stgk_room_monitor")
@ApiModel(value = "RoomMonitor对象", description = "")
public class RoomMonitor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("配电室id")
    private Integer roomId;

    @ApiModelProperty("温度")
    private BigDecimal temperature;

    @ApiModelProperty("湿度")
    private BigDecimal humidity;

    @ApiModelProperty("监控时间")
    private LocalDateTime monitorTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }
    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }
    public LocalDateTime getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(LocalDateTime monitorTime) {
        this.monitorTime = monitorTime;
    }

    @Override
    public String toString() {
        return "RoomMonitor{" +
            "id=" + id +
            ", roomId=" + roomId +
            ", temperature=" + temperature +
            ", humidity=" + humidity +
            ", monitorTime=" + monitorTime +
        "}";
    }
}
