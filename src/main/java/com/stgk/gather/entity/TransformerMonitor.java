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
 * @since 2023-03-29
 */
@TableName("stgk_transformer_monitor")
@ApiModel(value = "TransformerMonitor对象", description = "")
public class TransformerMonitor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("变压器id")
    private Integer transformerId;

    @ApiModelProperty("创建时间")
    private LocalDateTime monitorTime;

    @ApiModelProperty("电压")
    private BigDecimal transformerVoltage;

    @ApiModelProperty("A相电流")
    private BigDecimal transformerACurrent;

    @ApiModelProperty("B相电流")
    private BigDecimal transformerBCurrent;

    @ApiModelProperty("C相电流")
    private BigDecimal transformerCCurrent;

    @ApiModelProperty("功率因数")
    private BigDecimal transformerPower;

    @ApiModelProperty("A相烧组温度")
    private BigDecimal aBurnerTemperature;

    @ApiModelProperty("B相烧组温度")
    private BigDecimal bBurnerTemperature;

    @ApiModelProperty("C相烧组温度")
    private BigDecimal cBurnerTemperature;

    @ApiModelProperty("A相出线温度")
    private BigDecimal aOutletTemperature;

    @ApiModelProperty("B相出线温度")
    private BigDecimal bOutletTemperature;

    @ApiModelProperty("C相出线温度")
    private BigDecimal cOutletTemperature;

    @ApiModelProperty("铁芯温度")
    private BigDecimal coreTemperature;

    @ApiModelProperty("环境温度")
    private BigDecimal ambientTemperature;

    @ApiModelProperty("红外温度")
    private BigDecimal redTemperature;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getTransformerId() {
        return transformerId;
    }

    public void setTransformerId(Integer transformerId) {
        this.transformerId = transformerId;
    }
    public LocalDateTime getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(LocalDateTime monitorTime) {
        this.monitorTime = monitorTime;
    }
    public BigDecimal getTransformerVoltage() {
        return transformerVoltage;
    }

    public void setTransformerVoltage(BigDecimal transformerVoltage) {
        this.transformerVoltage = transformerVoltage;
    }
    public BigDecimal getTransformerACurrent() {
        return transformerACurrent;
    }

    public void setTransformerACurrent(BigDecimal transformerACurrent) {
        this.transformerACurrent = transformerACurrent;
    }
    public BigDecimal getTransformerBCurrent() {
        return transformerBCurrent;
    }

    public void setTransformerBCurrent(BigDecimal transformerBCurrent) {
        this.transformerBCurrent = transformerBCurrent;
    }
    public BigDecimal getTransformerCCurrent() {
        return transformerCCurrent;
    }

    public void setTransformerCCurrent(BigDecimal transformerCCurrent) {
        this.transformerCCurrent = transformerCCurrent;
    }
    public BigDecimal getTransformerPower() {
        return transformerPower;
    }

    public void setTransformerPower(BigDecimal transformerPower) {
        this.transformerPower = transformerPower;
    }
    public BigDecimal getaBurnerTemperature() {
        return aBurnerTemperature;
    }

    public void setaBurnerTemperature(BigDecimal aBurnerTemperature) {
        this.aBurnerTemperature = aBurnerTemperature;
    }
    public BigDecimal getbBurnerTemperature() {
        return bBurnerTemperature;
    }

    public void setbBurnerTemperature(BigDecimal bBurnerTemperature) {
        this.bBurnerTemperature = bBurnerTemperature;
    }
    public BigDecimal getcBurnerTemperature() {
        return cBurnerTemperature;
    }

    public void setcBurnerTemperature(BigDecimal cBurnerTemperature) {
        this.cBurnerTemperature = cBurnerTemperature;
    }
    public BigDecimal getaOutletTemperature() {
        return aOutletTemperature;
    }

    public void setaOutletTemperature(BigDecimal aOutletTemperature) {
        this.aOutletTemperature = aOutletTemperature;
    }
    public BigDecimal getbOutletTemperature() {
        return bOutletTemperature;
    }

    public void setbOutletTemperature(BigDecimal bOutletTemperature) {
        this.bOutletTemperature = bOutletTemperature;
    }
    public BigDecimal getcOutletTemperature() {
        return cOutletTemperature;
    }

    public void setcOutletTemperature(BigDecimal cOutletTemperature) {
        this.cOutletTemperature = cOutletTemperature;
    }
    public BigDecimal getCoreTemperature() {
        return coreTemperature;
    }

    public void setCoreTemperature(BigDecimal coreTemperature) {
        this.coreTemperature = coreTemperature;
    }
    public BigDecimal getAmbientTemperature() {
        return ambientTemperature;
    }

    public void setAmbientTemperature(BigDecimal ambientTemperature) {
        this.ambientTemperature = ambientTemperature;
    }

    public BigDecimal getRedTemperature() {
        return redTemperature;
    }

    public void setRedTemperature(BigDecimal redTemperature) {
        this.redTemperature = redTemperature;
    }

    @Override
    public String toString() {
        return "TransformerMonitor{" +
            "id=" + id +
            ", transformerId=" + transformerId +
            ", monitorTime=" + monitorTime +
            ", transformerVoltage=" + transformerVoltage +
            ", transformerACurrent=" + transformerACurrent +
            ", transformerBCurrent=" + transformerBCurrent +
            ", transformerCCurrent=" + transformerCCurrent +
            ", transformerPower=" + transformerPower +
            ", aBurnerTemperature=" + aBurnerTemperature +
            ", bBurnerTemperature=" + bBurnerTemperature +
            ", cBurnerTemperature=" + cBurnerTemperature +
            ", aOutletTemperature=" + aOutletTemperature +
            ", bOutletTemperature=" + bOutletTemperature +
            ", cOutletTemperature=" + cOutletTemperature +
            ", coreTemperature=" + coreTemperature +
            ", ambientTemperature=" + ambientTemperature +
        "}";
    }
}
