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
 * @since 2023-04-20
 */
@TableName("stgk_voltage_cabinet_monitor")
@ApiModel(value = "VoltageCabinetMonitor对象", description = "")
public class VoltageCabinetMonitor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("所属配电室id")
    private Integer cabinetId;

    @ApiModelProperty("A相电流")
    private BigDecimal aCurrent;

    @ApiModelProperty("B相电流")
    private BigDecimal bCurrent;

    @ApiModelProperty("C相电流")
    private BigDecimal cCurrent;

    @ApiModelProperty("UAB电压")
    private BigDecimal uabVoltage;

    @ApiModelProperty("P功率")
    private BigDecimal pPower;

    @ApiModelProperty("cos")
    private BigDecimal cos;

    @ApiModelProperty("rh")
    private BigDecimal rh;

    @ApiModelProperty("pd")
    private BigDecimal pd;

    @ApiModelProperty("断路器上口A相温度")
    private BigDecimal breakerUpAcurrent;

    @ApiModelProperty("断路器上口B相温度")
    private BigDecimal breakerUpBcurrent;

    @ApiModelProperty("断路器上口C相温度")
    private BigDecimal breakerUpCcurrent;

    @ApiModelProperty("断路器下口A相温度")
    private BigDecimal breakerDownAcurrent;

    @ApiModelProperty("断路器下口B相温度")
    private BigDecimal breakerDownBcurrent;

    @ApiModelProperty("断路器下口C相温度")
    private BigDecimal breakerDownCcurrent;

    @ApiModelProperty("断路器出口A相温度")
    private BigDecimal breakerOutAcurrent;

    @ApiModelProperty("断路器出口B相温度")
    private BigDecimal breakerOutBcurrent;

    @ApiModelProperty("断路器出口C相温度")
    private BigDecimal breakerOutCcurrent;

    @ApiModelProperty("合闸线圈电流")
    private BigDecimal closingCoilCurrent;

    @ApiModelProperty("分闸线圈电流")
    private BigDecimal openingCoilCurrent;

    @ApiModelProperty("储能电机电流")
    private BigDecimal storageMotorCurrent;

    @ApiModelProperty("位移值")
    private BigDecimal displacement;

    @ApiModelProperty("行程")
    private BigDecimal trip;

    @ApiModelProperty("监控时间")
    private LocalDateTime monitorTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(Integer cabinetId) {
        this.cabinetId = cabinetId;
    }
    public BigDecimal getaCurrent() {
        return aCurrent;
    }

    public void setaCurrent(BigDecimal aCurrent) {
        this.aCurrent = aCurrent;
    }
    public BigDecimal getbCurrent() {
        return bCurrent;
    }

    public void setbCurrent(BigDecimal bCurrent) {
        this.bCurrent = bCurrent;
    }
    public BigDecimal getcCurrent() {
        return cCurrent;
    }

    public void setcCurrent(BigDecimal cCurrent) {
        this.cCurrent = cCurrent;
    }
    public BigDecimal getUabVoltage() {
        return uabVoltage;
    }

    public void setUabVoltage(BigDecimal uabVoltage) {
        this.uabVoltage = uabVoltage;
    }
    public BigDecimal getpPower() {
        return pPower;
    }

    public void setpPower(BigDecimal pPower) {
        this.pPower = pPower;
    }
    public BigDecimal getCos() {
        return cos;
    }

    public void setCos(BigDecimal cos) {
        this.cos = cos;
    }
    public BigDecimal getRh() {
        return rh;
    }

    public void setRh(BigDecimal rh) {
        this.rh = rh;
    }
    public BigDecimal getPd() {
        return pd;
    }

    public void setPd(BigDecimal pd) {
        this.pd = pd;
    }
    public BigDecimal getBreakerUpAcurrent() {
        return breakerUpAcurrent;
    }

    public void setBreakerUpAcurrent(BigDecimal breakerUpAcurrent) {
        this.breakerUpAcurrent = breakerUpAcurrent;
    }
    public BigDecimal getBreakerUpBcurrent() {
        return breakerUpBcurrent;
    }

    public void setBreakerUpBcurrent(BigDecimal breakerUpBcurrent) {
        this.breakerUpBcurrent = breakerUpBcurrent;
    }
    public BigDecimal getBreakerUpCcurrent() {
        return breakerUpCcurrent;
    }

    public void setBreakerUpCcurrent(BigDecimal breakerUpCcurrent) {
        this.breakerUpCcurrent = breakerUpCcurrent;
    }
    public BigDecimal getBreakerDownAcurrent() {
        return breakerDownAcurrent;
    }

    public void setBreakerDownAcurrent(BigDecimal breakerDownAcurrent) {
        this.breakerDownAcurrent = breakerDownAcurrent;
    }
    public BigDecimal getBreakerDownBcurrent() {
        return breakerDownBcurrent;
    }

    public void setBreakerDownBcurrent(BigDecimal breakerDownBcurrent) {
        this.breakerDownBcurrent = breakerDownBcurrent;
    }
    public BigDecimal getBreakerDownCcurrent() {
        return breakerDownCcurrent;
    }

    public void setBreakerDownCcurrent(BigDecimal breakerDownCcurrent) {
        this.breakerDownCcurrent = breakerDownCcurrent;
    }
    public BigDecimal getBreakerOutAcurrent() {
        return breakerOutAcurrent;
    }

    public void setBreakerOutAcurrent(BigDecimal breakerOutAcurrent) {
        this.breakerOutAcurrent = breakerOutAcurrent;
    }
    public BigDecimal getBreakerOutBcurrent() {
        return breakerOutBcurrent;
    }

    public void setBreakerOutBcurrent(BigDecimal breakerOutBcurrent) {
        this.breakerOutBcurrent = breakerOutBcurrent;
    }
    public BigDecimal getBreakerOutCcurrent() {
        return breakerOutCcurrent;
    }

    public void setBreakerOutCcurrent(BigDecimal breakerOutCcurrent) {
        this.breakerOutCcurrent = breakerOutCcurrent;
    }
    public BigDecimal getClosingCoilCurrent() {
        return closingCoilCurrent;
    }

    public void setClosingCoilCurrent(BigDecimal closingCoilCurrent) {
        this.closingCoilCurrent = closingCoilCurrent;
    }
    public BigDecimal getOpeningCoilCurrent() {
        return openingCoilCurrent;
    }

    public void setOpeningCoilCurrent(BigDecimal openingCoilCurrent) {
        this.openingCoilCurrent = openingCoilCurrent;
    }
    public BigDecimal getStorageMotorCurrent() {
        return storageMotorCurrent;
    }

    public void setStorageMotorCurrent(BigDecimal storageMotorCurrent) {
        this.storageMotorCurrent = storageMotorCurrent;
    }
    public BigDecimal getDisplacement() {
        return displacement;
    }

    public void setDisplacement(BigDecimal displacement) {
        this.displacement = displacement;
    }
    public BigDecimal getTrip() {
        return trip;
    }

    public void setTrip(BigDecimal trip) {
        this.trip = trip;
    }
    public LocalDateTime getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(LocalDateTime monitorTime) {
        this.monitorTime = monitorTime;
    }

    @Override
    public String toString() {
        return "VoltageCabinetMonitor{" +
            "id=" + id +
            ", cabinetId=" + cabinetId +
            ", aCurrent=" + aCurrent +
            ", bCurrent=" + bCurrent +
            ", cCurrent=" + cCurrent +
            ", uabVoltage=" + uabVoltage +
            ", pPower=" + pPower +
            ", cos=" + cos +
            ", rh=" + rh +
            ", pd=" + pd +
            ", breakerUpAcurrent=" + breakerUpAcurrent +
            ", breakerUpBcurrent=" + breakerUpBcurrent +
            ", breakerUpCcurrent=" + breakerUpCcurrent +
            ", breakerDownAcurrent=" + breakerDownAcurrent +
            ", breakerDownBcurrent=" + breakerDownBcurrent +
            ", breakerDownCcurrent=" + breakerDownCcurrent +
            ", breakerOutAcurrent=" + breakerOutAcurrent +
            ", breakerOutBcurrent=" + breakerOutBcurrent +
            ", breakerOutCcurrent=" + breakerOutCcurrent +
            ", closingCoilCurrent=" + closingCoilCurrent +
            ", openingCoilCurrent=" + openingCoilCurrent +
            ", storageMotorCurrent=" + storageMotorCurrent +
            ", displacement=" + displacement +
            ", trip=" + trip +
            ", monitorTime=" + monitorTime +
        "}";
    }
}
