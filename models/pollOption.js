const { sequelize, Sequelize } = require("../models/index");

const PollOption = sequelize.define("PollOption", {
  poll_option_id: {
    type: DataTypes.INTEGER,
    primaryKey: true,
    autoIncrement: true,
  },
  poll_id: { type: DataTypes.INTEGER, allowNull: false },
  poll_option_content: { type: DataTypes.STRING(255), allowNull: false },
  //voters: { type: DataTypes.ARRAY(DataTypes.INTEGER), allowNull: true },
  voters: { type: DataTypes.JSON, allowNull: true },
});

Poll.hasMany(PollOption, { foreignKey: "poll_id" });
PollOption.belongsTo(Poll, { foreignKey: "poll_id" });

module.exports = PollOption;
