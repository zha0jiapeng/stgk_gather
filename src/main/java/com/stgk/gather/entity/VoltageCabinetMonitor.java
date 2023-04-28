package com.stgk.gather.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author mashir0zhao
 * @since 2023-04-27
 */
@TableName("stgk_voltage_cabinet_monitor")
@ApiModel(value = "VoltageCabinetMonitor对象", description = "")
@Data
public class VoltageCabinetMonitor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("所属配电室id")
    private Integer cabinetId;

    @ApiModelProperty("A相电流")
    private BigDecimal aCurrent;

    @ApiModelProperty("A相电压")
    private BigDecimal aVoltage;

    @ApiModelProperty("B相电流")
    private BigDecimal bCurrent;

    @ApiModelProperty("B相电压")
    private BigDecimal bVoltage;

    @ApiModelProperty("C相电流")
    private BigDecimal cCurrent;

    @ApiModelProperty("C相电压")
    private BigDecimal cVoltage;

    @ApiModelProperty("有功功率")
    private BigDecimal activePower;

    @ApiModelProperty("UAB电压")
    private BigDecimal uabVoltage;

    @ApiModelProperty("无功功率")
    private BigDecimal reactivePower;

    @ApiModelProperty("UAC电压")
    private BigDecimal uacVoltage;

    @ApiModelProperty("功率因数")
    private BigDecimal powerFactor;

    @ApiModelProperty("UBC电压")
    private BigDecimal ubcVoltage;

    @ApiModelProperty("柜内温度")
    private BigDecimal temperature;

    @ApiModelProperty("柜内湿度")
    private BigDecimal humidity;

    @ApiModelProperty("放电量")
    private BigDecimal dischargeCapacity;

    @ApiModelProperty("放电次数")
    private BigDecimal dischargeFrequency;

    @ApiModelProperty("断路器上口A相温度")
    private BigDecimal breakerUpATemperature;

    @ApiModelProperty("断路器上口B相温度")
    private BigDecimal breakerUpBTemperature;

    @ApiModelProperty("断路器上口C相温度")
    private BigDecimal breakerUpCTemperature;

    @ApiModelProperty("断路器下口A相温度")
    private BigDecimal breakerDownATemperature;

    @ApiModelProperty("断路器下口B相温度")
    private BigDecimal breakerDownBTemperature;

    @ApiModelProperty("断路器下口C相温度")
    private BigDecimal breakerDownCTemperature;

    @ApiModelProperty("断路器出口A相温度")
    private BigDecimal breakerOutATemperature;

    @ApiModelProperty("断路器出口B相温度")
    private BigDecimal breakerOutBTemperature;

    @ApiModelProperty("断路器出口C相温度")
    private BigDecimal breakerOutCTemperature;

    @ApiModelProperty("断路器上口报警温度")
    private BigDecimal breakerUpReportTemperature;

    @ApiModelProperty("断路器下口报警温度")
    private BigDecimal breakerDownReportTemperature;

    @ApiModelProperty("断路器出口报警温度")
    private BigDecimal breakerOutReportTemperature;

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

}
