package com.stgk.gather.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author mashir0zhao
 * @since 2023-03-16
 */
@TableName("stgk_cable_index_monitor")
@ApiModel(value = "CableIndexMonitor对象", description = "")
public class CableIndexMonitor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("电缆id")
    private Integer cableId;

    @ApiModelProperty("电缆温度")
    private BigDecimal cableTemperature;

    @ApiModelProperty("电缆最高温度")
    private BigDecimal cableCurrent;

    @ApiModelProperty("寄存器下标")
    private Integer sensorIndex;

    @ApiModelProperty("监测时间")
    private LocalDateTime monitorTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCableId() {
        return cableId;
    }

    public void setCableId(Integer cableId) {
        this.cableId = cableId;
    }

    public BigDecimal getCableTemperature() {
        return cableTemperature;
    }

    public void setCableTemperature(BigDecimal cableTemperature) {
        this.cableTemperature = cableTemperature;
    }

    public Integer getSensorIndex() {
        return sensorIndex;
    }

    public void setSensorIndex(Integer sensorIndex) {
        this.sensorIndex = sensorIndex;
    }

    public LocalDateTime getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(LocalDateTime monitorTime) {
        this.monitorTime = monitorTime;
    }

    public BigDecimal getCableCurrent() {
        return cableCurrent;
    }

    public void setCableCurrent(BigDecimal cableCurrent) {
        this.cableCurrent = cableCurrent;
    }
}
