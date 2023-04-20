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
 * @since 2023-03-16
 */
@TableName("stgk_cable")
@ApiModel(value = "Cable对象", description = "")
public class Cable implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("电缆编号")
    private String cableNumber;

    @ApiModelProperty("电缆名称")
    private String cableName;

    @ApiModelProperty("电缆状态 0健康 1异常 2危险")
    private Integer cableStatus;

    @ApiModelProperty("电缆备注")
    private String cableRemark;

    @ApiModelProperty("电缆电压等级")
    private String cableVoltageLevel;

    @ApiModelProperty("电缆总长度")
    private Integer cableLength;

    @ApiModelProperty("电缆预警温度值")
    private Integer cableEarlyWarning;

    @ApiModelProperty("电缆告警温度值")
    private Integer cableReportWarning;

    @ApiModelProperty("电缆报警温度值")
    private Integer cableAlarmWarning;

    @ApiModelProperty("电缆24小时内最高温度")
    private BigDecimal cableMaxTemperature;

    @ApiModelProperty("电缆24小时内最低温度")
    private BigDecimal cableMinTemperature;

    @ApiModelProperty("电缆24小时内平均温度")
    private BigDecimal cableAvgTemperature;

    @ApiModelProperty("电缆从机地址")
    private Integer cableSlaveId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("更新者")
    private String updateBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCableNumber() {
        return cableNumber;
    }

    public void setCableNumber(String cableNumber) {
        this.cableNumber = cableNumber;
    }

    public String getCableName() {
        return cableName;
    }

    public void setCableName(String cableName) {
        this.cableName = cableName;
    }

    public Integer getCableStatus() {
        return cableStatus;
    }

    public void setCableStatus(Integer cableStatus) {
        this.cableStatus = cableStatus;
    }

    public String getCableRemark() {
        return cableRemark;
    }

    public void setCableRemark(String cableRemark) {
        this.cableRemark = cableRemark;
    }

    public String getCableVoltageLevel() {
        return cableVoltageLevel;
    }

    public void setCableVoltageLevel(String cableVoltageLevel) {
        this.cableVoltageLevel = cableVoltageLevel;
    }

    public Integer getCableLength() {
        return cableLength;
    }

    public void setCableLength(Integer cableLength) {
        this.cableLength = cableLength;
    }

    public Integer getCableEarlyWarning() {
        return cableEarlyWarning;
    }

    public void setCableEarlyWarning(Integer cableEarlyWarning) {
        this.cableEarlyWarning = cableEarlyWarning;
    }

    public Integer getCableReportWarning() {
        return cableReportWarning;
    }

    public void setCableReportWarning(Integer cableReportWarning) {
        this.cableReportWarning = cableReportWarning;
    }

    public Integer getCableAlarmWarning() {
        return cableAlarmWarning;
    }

    public void setCableAlarmWarning(Integer cableAlarmWarning) {
        this.cableAlarmWarning = cableAlarmWarning;
    }

    public BigDecimal getCableMaxTemperature() {
        return cableMaxTemperature;
    }

    public void setCableMaxTemperature(BigDecimal cableMaxTemperature) {
        this.cableMaxTemperature = cableMaxTemperature;
    }

    public BigDecimal getCableMinTemperature() {
        return cableMinTemperature;
    }

    public void setCableMinTemperature(BigDecimal cableMinTemperature) {
        this.cableMinTemperature = cableMinTemperature;
    }

    public BigDecimal getCableAvgTemperature() {
        return cableAvgTemperature;
    }

    public void setCableAvgTemperature(BigDecimal cableAvgTemperature) {
        this.cableAvgTemperature = cableAvgTemperature;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getCableSlaveId() {
        return cableSlaveId;
    }

    public void setCableSlaveId(Integer cableSlaveId) {
        this.cableSlaveId = cableSlaveId;
    }

    @Override
    public String toString() {
        return "Cable{" +
            "id = " + id +
            ", cableNumber = " + cableNumber +
            ", cableName = " + cableName +
            ", cableStatus = " + cableStatus +
            ", cableRemark = " + cableRemark +
            ", cableVoltageLevel = " + cableVoltageLevel +
            ", cableLength = " + cableLength +
            ", cableEarlyWarning = " + cableEarlyWarning +
            ", cableReportWarning = " + cableReportWarning +
            ", cableAlarmWarning = " + cableAlarmWarning +
            ", cableMaxTemperature = " + cableMaxTemperature +
            ", cableMinTemperature = " + cableMinTemperature +
            ", cableAvgTemperature = " + cableAvgTemperature +
            ", createTime = " + createTime +
            ", createBy = " + createBy +
            ", updateTime = " + updateTime +
            ", updateBy = " + updateBy +
        "}";
    }
}
