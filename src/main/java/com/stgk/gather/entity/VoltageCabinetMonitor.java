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

    /** 断路器上口A相温度 */
    private BigDecimal breakerUpATemperature;

    /** 断路器上口B相温度 */
    private BigDecimal breakerUpBTemperature;

    /** 断路器上口C相温度 */
    private BigDecimal breakerUpCTemperature;

    /** 断路器下口A相温度 */
    private BigDecimal breakerDownATemperature;

    /** 断路器下口B相温度 */
    private BigDecimal breakerDownBTemperature;

    /** 断路器下口C相温度 */
    private BigDecimal breakerDownCTemperature;

    /** 断路器出口A相温度 */
    private BigDecimal breakerOutATemperature;

    /** 断路器出口B相温度 */
    private BigDecimal breakerOutBTemperature;

    /** 断路器出口C相温度 */
    private BigDecimal breakerOutCTemperature;
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

    public BigDecimal getBreakerUpATemperature() {
        return breakerUpATemperature;
    }

    public void setBreakerUpATemperature(BigDecimal breakerUpATemperature) {
        this.breakerUpATemperature = breakerUpATemperature;
    }

    public BigDecimal getBreakerUpBTemperature() {
        return breakerUpBTemperature;
    }

    public void setBreakerUpBTemperature(BigDecimal breakerUpBTemperature) {
        this.breakerUpBTemperature = breakerUpBTemperature;
    }

    public BigDecimal getBreakerUpCTemperature() {
        return breakerUpCTemperature;
    }

    public void setBreakerUpCTemperature(BigDecimal breakerUpCTemperature) {
        this.breakerUpCTemperature = breakerUpCTemperature;
    }

    public BigDecimal getBreakerDownATemperature() {
        return breakerDownATemperature;
    }

    public void setBreakerDownATemperature(BigDecimal breakerDownATemperature) {
        this.breakerDownATemperature = breakerDownATemperature;
    }

    public BigDecimal getBreakerDownBTemperature() {
        return breakerDownBTemperature;
    }

    public void setBreakerDownBTemperature(BigDecimal breakerDownBTemperature) {
        this.breakerDownBTemperature = breakerDownBTemperature;
    }

    public BigDecimal getBreakerDownCTemperature() {
        return breakerDownCTemperature;
    }

    public void setBreakerDownCTemperature(BigDecimal breakerDownCTemperature) {
        this.breakerDownCTemperature = breakerDownCTemperature;
    }

    public BigDecimal getBreakerOutATemperature() {
        return breakerOutATemperature;
    }

    public void setBreakerOutATemperature(BigDecimal breakerOutATemperature) {
        this.breakerOutATemperature = breakerOutATemperature;
    }

    public BigDecimal getBreakerOutBTemperature() {
        return breakerOutBTemperature;
    }

    public void setBreakerOutBTemperature(BigDecimal breakerOutBTemperature) {
        this.breakerOutBTemperature = breakerOutBTemperature;
    }

    public BigDecimal getBreakerOutCTemperature() {
        return breakerOutCTemperature;
    }

    public void setBreakerOutCTemperature(BigDecimal breakerOutCTemperature) {
        this.breakerOutCTemperature = breakerOutCTemperature;
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
            ", closingCoilCurrent=" + closingCoilCurrent +
            ", openingCoilCurrent=" + openingCoilCurrent +
            ", storageMotorCurrent=" + storageMotorCurrent +
            ", displacement=" + displacement +
            ", trip=" + trip +
            ", monitorTime=" + monitorTime +
        "}";
    }
}
