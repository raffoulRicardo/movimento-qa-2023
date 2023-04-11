require 'capybara'
require 'capybara/cucumber'
require 'rspec'
require 'selenium-webdriver'
require 'rspec/retry'

=begin
Capybara.register_driver :selenium do |app|
    Capybara::Selenium::Driver.new(app, browser: :chrome)
  end
  
  Capybara.configure do |config|
    config.default_driver = :selenium
    config.app_host = "http://localhost:8080/"
  end
=end